interface SensitiveData { }  // Marker Interface

class UserInfo implements SensitiveData {
    String name = "John";
    String ssn = "123-45-6789";
}
