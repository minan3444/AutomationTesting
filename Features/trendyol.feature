Feature: Trendyol 
Description: Trendyol test scenario

Background:
Given Trendyol sayfasını tarayıcıda açarım

Scenario: Kullanicinin Basarili olarak Sisteme Giris Yapmasi
And Giriş yap butonuna tıklarsam
And Sisteme kayıtlı birkullanıcı ile giriş yapılırsa
Then Ana sayfada tabların yüklenip yüklenmediğinin kontrolü yapılır
And rastgele bir butiğe gidilerek ürün görsellerinin yüklendiği görülür
And rastgele bir ürün detayına gidilir
And ürün sepete eklenir