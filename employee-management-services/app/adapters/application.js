import DS from 'ember-data';

export default DS.RESTAdapter.extend({
	//namespace: 'api',
	//host: 'http://172.31.18.94:8080'
	host: "http://localhost:8080"
});