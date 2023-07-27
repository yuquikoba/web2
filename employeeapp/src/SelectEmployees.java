import java.util.List;

import dao.EmployeesDAO;
import model.Employee;

public class SelectEmployees {

	public static void main(String[] args) {
		EmployeesDAO empDAO=new EmployeesDAO();
		List<Employee> empList=empDAO.findAll();
		
		for(Employee emp:empList) {
			System.out.println("ID:"+emp.getId());
			System.out.println("名前:"+emp.getName());
			System.out.println("年齢:"+emp.getAge()+"\n");
		}
		if(empDAO.remove(1)) {
			System.out.println("1件削除しました");
		}else {
			System.out.println("削除できませんでした");
		}

	}

}
