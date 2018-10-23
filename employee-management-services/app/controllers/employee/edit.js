import Controller from '@ember/controller';

export default Controller.extend({
	actions:{
		updateEmployee(){
			let self=this;
			//let empId=self.get("model").get("id");
			//self.get("model").set("empId",empId);
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