package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RegisterLogic {
	public void execute(Product product,List<Product> productList) {
		Date today=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateTime=sdf.format(today);
		product.setDateTime(dateTime);
		productList.add(0,product);
	}

}
