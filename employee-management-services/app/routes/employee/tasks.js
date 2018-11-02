import Route from '@ember/routing/route';

export default Route.extend({
	empId:undefined,
	model:function(params){
		this.set("empId",params.employee_id);
		return this.store.findAll('task',{
			adapterOptions: {
				empId: params.employee_id
			}
			/*reload: true */
			/*include: 'employee,employee.firstName'*/
		});
	},
	setupController(controller){
		let empId=this.get("empId");
		controller.set("empId",empId);
	}
});
