#!/bin/bash
# Script para deployment del backend

sudo apt -y install software-properties-common
sudo apt-add-repository 'deb http://security.debian.org/debian-security stretch/updates main'
sudo apt update
sudo apt -y install openjdk-8-jdk

./mvnw clean install
sudo java -jar target/sia-0.0.1-SNAPSHOT.jar &
