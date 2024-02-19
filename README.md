# Spring Boot Notlarım

## Spring Boot Starterlar 
Spring Boot starterlar  ihtiyaç duyduğumuz kabiliyetleri pom.xml’e ekleyerek kullanabileceğimiz bağımlılık tanımlarıdır.   
•	 Spring Boot Devtools, kod değişiklikleri yapıp kaydettikten sonra uygulamayı yeniden başlatmadan değişikliklerin otomatik olarak uygulanmasını sağlar. (normalde durdurup uygulamayı tekrar çalıştırarak görebiliriz.)  
•	 Spring Boot Actutator, Spring Boot uygulamasını yönetmek ve izlemek için kullanılan bir toldur. Uygulamanın rum timeda bir çok farklı veriyi toplar ve bunları bir REST API ile erişilebilir hale getirir. spring-boot-starter-actuator kütüphanesini pom.xml’e ekledikten sonra **localhost:8080/actuator** adresine gidersek  self, health ve health-path bilgilerine ulaşabiliriz. Properties dosyasına;       
				management.endpoints.web.expose=* (or health,info)
eklersek bütün endpointler gelir. 

## Properties Dosyası 
•	Spring framework kaynaklı logların hangi seviyede izleneceğini belirlemek için ;    
logging.level.org.springframework=debug  
•	Diyelim ki elimde üç tane properties  dosyası var. Uygulamanın kullandığı application.properties, canlıya çıkmadan önce denemek için application-dev.properties ve canlıda kullanacağım application-prop.properties. Hangi application dosyasını kullacağımı belirlemek için  application.properties dosyamda ;
				spring.profiles.active=dev
				spring.profiles.active=prop
tanımlaması yapılmalı. Bu satır ile spring bootun hangi profille çalışacağını belirlemiş oluruz.   
•	Endpointleri (actuator) görebilmek için;  
				management.endpoints.web.expose=*
				management.endpoints.web.expose=health,info

