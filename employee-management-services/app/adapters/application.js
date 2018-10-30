import DS from 'ember-data';

export default DS.RESTAdapter.extend({
	//namespace: 'api',
	host: 'http://13.59.7.16:8080'
});