import Controller from '@ember/controller';

export default Controller.extend({
	phoneNo:undefined,
	address:"",
	dateOfBirth:undefined,
	langKnown:'',
	actions:{
		saveEmpDetails(){
			let self=this;
			let empDetails=this.store.createRecord('emp-details',{
				phoneNo:self.get("phoneNo"),
				address:self.get("address"),
				dateOfBirth:self.get("dateOfBirth"),
				langKnown:self.get("langKnown")
			});
			empDetails.save().then(function() {
				self.transitionToRoute('employee');
			}, function(resp) {
				if (resp.responseJSON) {
					self.get('model').set('errors', resp.responseJSON.errors);
				} 
			});
		}
	}
});
