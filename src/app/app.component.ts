import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Observable} from'rxjs';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  emp:EmployeeService;
  constructor(emp:EmployeeService){
      this.emp=emp;
  }

  allemployees: any[]=[];

  formHeader="Add Employee";
  employeeId=0;
  employeeName="";
  department="";
  salary=0;
  showForm=false;
  showLabel=false;

  ngOnInit(): void{
    this.getEmployees();
  }
  getEmployees(){
    this.emp.fetchEmployees().subscribe((data)=>{
      this.allemployees=[...data];
      console.log(data);
    },
    (err) => {
      console.log(err);
    }
  );
  }

  deleteEmployee(id : number):void{
    this.emp.deleteEmployee(id).subscribe(
      (res)=>{
        this.getEmployees()
      }
    )
  }
  openForm(data:any){
    this.showForm=true;
    this.showLabel=true;
    if(data){
      this.employeeId=data.id;
      this.employeeName=data.name;
      this.department=data.department;
      this.salary=data.salary;
      this.formHeader="Edit Employee";
    }
  }
  openForm1(){
    this.showForm=true;
    this.showLabel=false;
    this.employeeId=0;
      this.employeeName="";
      this.department="";
      this.salary=0;
    this.formHeader="Add Employee";
  }
  closeForm(){
    this.showForm=false
  }
  

  saveEmployee(){
    this.showForm=false;
    let body={
      id:this.employeeId,
      name:this.employeeName,
      department:this.department,
      salary:this.salary
    }
    if(this.employeeId){
      body['id']=this.employeeId;
       this.emp.updateEmployee(this.employeeId,body).subscribe(
        (res)=>{
          this.getEmployees()
        }
      )
     
    }
    else{
      this.emp.postEmployee(body).subscribe(
        (res)=>{
          this.getEmployees()
        }
      )
    }
  }
}
