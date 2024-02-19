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

## Annotations

**@RequestMapping** annotation’ı, web uygulamamızın farklı bölümlerine karşılık gelen URL yollarını controller sınıfları ve yöntemleri ile ilişkilendirmek için kullanılır. Yani web tarayıcımızdan veya başka bir client’tan hangi URL’e erişildiğinde hangi controller’ın çalışacağını belirtir. Örneğin; @RequestMapping("/couses") olarak belirttiğimiz controller tarayıcıda  http://localhost:8080/courses adresinde çalışır. 
**@ConfigurationProperties** annotation’ı, Spring Boot uygulamasında dış kaynaklarda(properties dosyaları, ortam değişkenleri vb) gelen konfigürasyon değerlerini Java nesnelerine bağlamak için kullanılır. Sınıftaki fieldlar konfigürasyon keyleri ile ilişkilendirilir. @ConfigurationProperties(prefix="a-service") annotation’ı “a-service” ön eki ile başlayan konfigürasyon özelliklerini bir java classına bağlamak için kullanılır. Class’daki fieldlar, konfigürasyon keyleri ile eşleştirilir. Örneğin; classda “private String userName” fieldı bulunuyor. Bu prooerties dosyasında “a-service.userName” key’ine karşılık gelir. 

**@Component** annotation’ı, bir classa eklenerek o classı bir Spring bean olarak işaretlemek için kullanılır. Bu, Spring’e bu sınıfın bir bean olarak yönetilmesi ve ihtiyaç duyulduğunda otomatik olarak oluşturulması gerektiğini söyler. (Spring beanler Spring frameworkünün temel yapıtaşlarıdır. Otomatik yönetim, bağımlılık enjeksiyonu ve streotype annotationlar sayesinde Spring beanler kodumuzu daha temiz, okunabilir ve bakımı kolay hale getirir. )
**@Autowired** annotation’ı, bir beanin diğer beanlere olan bağımlılıklarını otomatik olarak enjekte etmek için kullanılır. Bu beanlerin birbirleriyle nasıl etkileşime gireceğini kodda açıkça belirtmemize gerek kalmadan springin otomatik olarak yapmasını sağlar. Aşağıdaki örnekte, UserService sınıfı @Service annotation'ı ile işaretlenmiştir. userRepository field'ı ise @Autowired annotation'ı ile işaretlenmiştir. Bu, Spring'e UserService bean'inin UserRepository bean'ine bağımlı olduğunu ve userRepository field'ına otomatik olarak enjekte etmesini söyler.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Kullanıcılarla ilgili iş mantığı kodları

}

