package se.contactbook.iths;
//

public class Contact {
        private String fullName;
        private String email;
        private String phoneNumber;
        private String address;


        public Contact(String fullname, String email, String phoneNumber, String address) {
                this.fullName = fullname;
                this.email = email;
                this.phoneNumber = phoneNumber;
                this.address = address;
        }

        public String getFullName() {
                return fullName;
        }

        public String getEmail() {
                return email;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public String getAddress() {
                return address;
        }
}