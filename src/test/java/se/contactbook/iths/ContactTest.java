package se.contactbook.iths;
//

class Contact {
        private String FullName;
        private String Email;
        private String PhoneNumber;
        private String Address;


        public Contact(String fullname, String email, String phoneNumber, String address) {
                this.FullName = fullname;
                this.Email = email;
                this.PhoneNumber = phoneNumber;
                this.Address = address;
        }

        public String getFullName() {
                return FullName;
        }

        public String getEmail() {
                return Email;
        }

        public String getPhoneNumber() {
                return PhoneNumber;
        }

        public String getAddress() {
                return Address;
        }
}