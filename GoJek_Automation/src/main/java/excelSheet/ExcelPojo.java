package excelSheet;

public class ExcelPojo {
	
	private static String cc_No, expiry_Date, cvv, otp;

	public static String getCc_No() {
		return cc_No;
	}

	public static void setCc_No(String cc_No) {
		ExcelPojo.cc_No = cc_No;
	}

	public static String getExpiry_Date() {
		return expiry_Date;
	}

	public static void setExpiry_Date(String expiry_Date) {
		ExcelPojo.expiry_Date = expiry_Date;
	}

	public static String getCvv() {
		return cvv;
	}

	public static void setCvv(String cvv) {
		ExcelPojo.cvv = cvv;
	}

	public static String getOtp() {
		return otp;
	}

	public static void setOtp(String otp) {
		ExcelPojo.otp = otp;
	}

}
