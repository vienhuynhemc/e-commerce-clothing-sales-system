package model.salary;

public class SalaryModel {

    private static SalaryModel salaryModel;

    public static SalaryModel getInstance(){
        if(salaryModel == null){
            salaryModel = new SalaryModel();
        }
        return salaryModel;
    }

    //  Phương thức nhận vô lương, trả ề string lương
    public String coverSalaryToString(int salary){
        String stringSalary = salary+"";
        String result ="";
        int count = 0;
        for(int i = stringSalary.length()-1 ; i>0;i--){
            count++;
            result = stringSalary.charAt(i)+result;
            if(count == 3){
                count = 0;
                result = ","+result;
            }
        }
        result = stringSalary.charAt(0)+result;
        return result+" VND";
    }


}
