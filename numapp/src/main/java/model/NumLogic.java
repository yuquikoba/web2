package model;

public class NumLogic {
	public void execute(Num num) {
		String number=num.getNumber();
		String[] numberArray=number.split(",");
		num.setLength(numberArray.length);
		int max,min,sum;
		max=min=sum=Integer.parseInt(numberArray[0]);
		for(int i=1;i<numberArray.length;i++) {
			int n=Integer.parseInt(numberArray[i]);
			if(max<n) {
				max=n;
			}
			if(min>n) {
				min=n;
			}
			sum+=n;
		}

		num.setMax(max);
		num.setMin(min);;
		num.setSum(sum);
	}

}
