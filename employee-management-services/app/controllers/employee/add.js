import Controller from '@ember/controller';

export default Controller.extend({
	firstName:"",
	lastName:"",
	email:"",
	designation:"",
	empType:"",
	eid:undefined,
	/*init:function(){
		this.set("firstName","");
		this.set("lastName","");
		this.set("email","");
		this.set("designation","");
		this.set("empType","");
		this.set("eid",undefined);
	},*/
	actions:{
		addEmployee(){
			let self=this;
			
			let emp=this.store.createRecord('employee',{
				firstName:self.get("firstName"),
				lastName:self.get("lastName"),
				email:self.get("email"),
				designation:self.get("designation"),
				empType:self.get("empType")
				//password:self.get("password")
			});
			emp.save().then(function() {
				self.transitionToRoute('employee.emp-details');
			}, function(resp) {
				if (resp.responseJSON) {
					self.get('model').set('errors', resp.responseJSON.errors);
				} 
			});
		}
	}
});
