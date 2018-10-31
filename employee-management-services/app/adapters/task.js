import DS from 'ember-data';

export default DS.RESTAdapter.extend({
	host: 'http://18.224.21.126:8080',
    urlForCreateRecord(modelName, snapshot) {
    	let empId=snapshot.belongsTo('employee').id;
        return `${this.host}/employees/${empId}/tasks`; // the url you want
    }
});