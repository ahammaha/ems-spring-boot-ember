import Controller from '@ember/controller';

export default Controller.extend({
	name:"sda",
	description:"asd",
	startDate:"1-10-2018",
	endDate:"02-10-2018",
	actions:{
		addTask(){
			let self=this;
			let employee=this.store.peekRecord("employee",1);
			
			let task=this.store.createRecord("tasks",{
				name:self.get("name"),
				description:self.get("description"),
				startDate:self.get("startDate"),
				endDate:self.get("endDate"),
				employee:employee
			});


			employee.get("tasks").pushObject(task);
			employee.save().then(function(resp){
				self.transitionToRoute("employee.tasks",resp);
			},function(respErr){
				if (respErr.responseJSON) {
					self.get('model').set('errors', respErr.responseJSON.errors);
				} 
			});

			/*
			console.log(task);
			task.save().then(function(resp){
				console.log("SUCCESS");
				self.transitionToRoute("employee.tasks",resp);
			},function(respErr){
				console.log(respErr);
				if (respErr.responseJSON) {
					self.get('model').set('errors', respErr.responseJSON.errors);
				} 
			});*/
		}
	}
});
