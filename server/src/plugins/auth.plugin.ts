import { FastifyInstance, FastifyPluginOptions } from 'fastify';
import fastifyPlugin from 'fastify-plugin';

const authPlugin = (app: FastifyInstance, _opts: FastifyPluginOptions, done: any) => {
	app.addHook('preHandler', async request => {});
	done();
};

export default fastifyPlugin(authPlugin);
