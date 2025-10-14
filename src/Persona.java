public class Persona {

    String firstName;
    String lastName;
    String email;
    String country;
    String gender;

    Persona(String firstName, String lastName, String email, String country, String gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Devuelve una cadena con todos los atributos separados por comas como en un CSV.
     * @return
     */
    @Override
    public String toString() {
        return firstName + "," + lastName + "," + email + "," + gender + "," + country;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Compara dos Personas por sus nombres y apellidos.
     * @param obj   the reference object with which to compare.
     * @return Si las dos Personas tienen nombres  y apellidos iguales.
     */
    @Override
    public boolean equals(Object obj) {

        boolean result = false;

        if (obj instanceof Persona p) {

            result = this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
        }

        return result;
    }
}
