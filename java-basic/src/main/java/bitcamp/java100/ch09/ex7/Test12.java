package bitcamp.java100.ch09.ex7;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
public class Test12 {
    static class MyKey {
        String id;
        String pwd;
        public MyKey(String id, String pwd) {
            this.id = id;
            this.pwd = pwd;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MyKey other = (MyKey) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            if (pwd == null) {
                if (other.pwd != null)
                    return false;
            } else if (!pwd.equals(other.pwd))
                return false;
            return true;
        }
        
    }
    static class Contact {
        String name;
        String email;
        String tel;
        public Contact(String name, String email, String tel) {
            this.name = name;
            this.email = email;
            this.tel = tel;
        }
        @Override
        public String toString() {
            return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + "]";
        }
    }
    public static void main(String[] args) {
        HashMap<String, Contact> map = new HashMap<>();
        map.put("c01", new Contact("홍길동1", "hong@test.com", "1111-1111"));
        map.put("c02", new Contact("홍길동2", "hong@test.com", "1111-1111"));
        map.put("c03", new Contact("홍길동3", "hong@test.com", "1111-1111"));
        map.put("c04", new Contact("홍길동4", "hong@test.com", "1111-1111"));
        map.put("c05", new Contact("홍길동5", "hong@test.com", "1111-1111"));
        
        Set<Entry<String, Contact>> entrySet = map.entrySet();
        
        for (Entry<String, Contact> entry : entrySet) {
            String key = entry.getKey();
            Contact contact = entry.getValue();
            System.out.printf("%S=%s\n", key, contact.name);
        }
    }
}
