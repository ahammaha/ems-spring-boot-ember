import Controller from '@ember/controller';

export default Controller.extend({
	name:"",
	description:"",
	startDate:"",
	endDate:"",
	empId:undefined,
	actions:{
		addTask(){
			let self=this;
			let employee=this.store.peekRecord("employee",this.get("empId"));

			let task=this.store.createRecord("task",{
				name:self.get("name"),
				description:self.get("description"),
				startDate:self.get("startDate"),
				endDate:self.get("endDate"),
				employee:employee
			});

			task.save().then(function(resp){
				self.transitionToRoute("employee.tasks",resp);
			},function(respErr){
				if (respErr.responseJSON) {
					self.get('model').set('errors', respErr.responseJSON.errors);
				} 
			});
		}
	}
});
