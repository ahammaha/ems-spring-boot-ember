import DS from 'ember-data';

export default DS.RESTAdapter.extend({
	//namespace: 'api',
	host: 'http://3.16.101.116:8080'
	//host: "http://localhost:8080"
});