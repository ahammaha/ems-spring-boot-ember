import Controller from '@ember/controller';

export default Controller.extend({
	username:"",
	password:"",
	actions:{
		login(){
			let self=this;
			let login=this.store.createRecord('login',{
				username:self.get("username"),
				password:self.get("password")
			});
			login.save().then(function(respData) {
				self.transitionToRoute('employee.disp-employee',respData);
			}, function(resp) {
				if (resp.responseJSON) {
					self.get('model').set('errors', resp.responseJSON.errors);
				} 
			});
		}
	}
});
