for(int i=0;i<departments.length;i++){
            if(departments[i]==null){
                System.out.print("Enter Department Name : ");
                String depName=sc.next();
                System.out.println("Now Enter That Department Employee data");
                System.out.print("Enter Employee name: ");
                String empName=sc.next();
                System.out.print("Enter Employee Id: ");
                String empId=sc.next();
                System.out.print("Enter Employee Designation : ");
                String empDes=sc.next();
                departments[i]=new Department(depName,new Employee(empId, empName, empDes));
                break;
            }
            else{
                System.out.println("There is no more space to make Department");
            }
        }