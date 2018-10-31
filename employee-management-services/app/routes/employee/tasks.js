import Route from '@ember/routing/route';

export default Route.extend({
	model:function(params){
		return this.store.findAll('task',params.employee_id);
	}
});
