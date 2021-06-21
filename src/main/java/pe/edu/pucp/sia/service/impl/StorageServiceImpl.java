package pe.edu.pucp.sia.service.impl;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageService{

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file){
        File fileObj=convertMultiPartFileToFile(file);
        String fileName=System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName,fileName,fileObj));
        fileObj.delete();
        return "File uploaded: "+fileName;
    }

    public byte[] downloadFile(String fileName){
        S3Object s3Object = s3Client.getOjbect(bucketName,fileName):
        S3OBjectInputStream inputStream = s3Object.getObjectContent();
        try{
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName,fileName);
        return fileName + "Object removed...";
    }

    private File convertMultiPartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        } catch(IOException e){
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}