import Controller from '@ember/controller';

export default Controller.extend({
	actions:{
		updateEmployee(){
			let self=this;
			console.log(self.get("model"))
			self.get("model").set("empId",1);
			let emp=this.store.createRecord('employee',self.get("model"));
			emp.save().then(function() {
				self.transitionToRoute('employee.disp-employee',self.get("model"));
			}, function(resp) {
				if (resp.responseJSON) {
					self.get('model').set('errors', resp.responseJSON.errors);
				} 
			});
		}
	}
});
