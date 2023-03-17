package business;

public class Person {

	private String name;
	private String geographic_data;
	private String dob;
	private String phone;
	private String email;
	private String ssn;
	private String imageTxt; // Health plan beneficiary number
	private String bankAccNum; // Bank account numbers
	private String departamento;
	public static int contador = -1;
	private String incorporacion;
	private double sueldo;

//Full face photos and comparable images
//Any unique identifying number, characteristic or code

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getIncorporacion() {
		return incorporacion;
	}

	public void setIncorporacion(String incorporacion) {
		this.incorporacion = incorporacion;
	}

	public Person(String name, String geographic_data, String dob, String phone, String email, String ssn, String imageTxt, String bankAccNum, String departamento, int contador, String incorporacion, double sueldo) {
		
	}
	
	public Person() {
		this.contador++;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getEmpcode() {
		return contador;
	}

	public void setEmpcode(int contador) {
		this.contador = contador;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeographic_data() {
		return geographic_data;
	}

	public void setGeographic_data(String geographic_data) {
		this.geographic_data = geographic_data;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getImagetxt() {
		return imageTxt;
	}

	public void setImageTxt(String imageTxt) {
		this.imageTxt = imageTxt;
	}

	public String getBankAccNum() {
		return bankAccNum;
	}

	public void setBankAccNum(String bankAccNum) {
		this.bankAccNum = bankAccNum;
	}

}