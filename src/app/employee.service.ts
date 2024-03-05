import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  contextPath = "http://localhost:2003/";
  getAllEmployees=this.contextPath+'employee/view';
  deleteEmp=this.contextPath+'employee/del';
  postEmp=this.contextPath+'employee/createEmp';
  updateEmp=this.contextPath+'employee'

  fetchEmployees():Observable<any>{
    return this.http.get<any>(`${this.getAllEmployees}`)
  }

  deleteEmployee(id : number):Observable<void>{
    return this.http.delete<void>(`${this.deleteEmp}/${id}`);
  }

  postEmployee(body:any):Observable<any>{
    return this.http.post<any>(`${this.postEmp}`,body)
  }

  updateEmployee(id:number,body:any):Observable<any>{
    return this.http.put<any>(`${this.updateEmp}/${id}`,body)
  }
}
