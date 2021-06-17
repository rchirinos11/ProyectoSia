package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecialtyUpdatePercentageRequest {
    private Integer idSpecialty;
    private Integer successPercentage;
}
