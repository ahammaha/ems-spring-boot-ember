import DS from 'ember-data';

export default DS.RESTAdapter.extend({
	//namespace: 'api',
	host: 'http://18.224.21.126:8080'
	//host: "http://localhost:8080"
});