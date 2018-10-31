import Route from '@ember/routing/route';

export default Route.extend({
	model:function(params){
		return this.store.findAll('task',{
			adapterOptions: {
				empId: params.employee_id
			}
			/*reload: true */
			/*include: 'employee,employee.firstName'*/
		});

	}
});
