import Component from '@ember/component';

export default Component.extend({
	actions:{
		selectDesignation(val){
			this.set("designation",val);
		},
		selectEmpType(val){
			this.set("empType",val);
		},
		saveEmployee(){
			this.submit();
		}
	}
});
