import Controller from '@ember/controller';

export default Controller.extend({
	firstName:"",
	lastName:"",
	email:"",
	designation:"",
	empType:"",
	eid:undefined,
	phoneNo:undefined,
	address:"",
	dateOfBirth:undefined,
	langKnown:'',
	actions:{
		addEmployee(){
			let self=this;
			
			let empdetailsObj=this.store.createRecord('empdetails',{
				firstName:self.get("firstName"),
				lastName:self.get("lastName"),
				designation:self.get("designation"),
				empType:self.get("empType"),
				phoneNo:self.get("phoneNo"),
				address:self.get("address"),
				dateOfBirth:self.get("dateOfBirth"),
				langKnown:self.get("langKnown")
			});

			let emp=this.store.createRecord('employee',{
				email:self.get("email"),
				empdetails:empdetailsObj,
			});

			let task=this.store.createRecord('task',{
				name:"Create Project",
				description:"Create an ember project",
				startDate:"30-10-2018"
			});

			emp.get("tasks").pushObject(task);

			emp.save().then(function(respData) {
				self.transitionToRoute('employee.disp-employee',respData);
			}, function(resp) {
				if (resp.responseJSON) {
					self.get('model').set('errors', resp.responseJSON.errors);
				} 
			});
		}
	}
});
