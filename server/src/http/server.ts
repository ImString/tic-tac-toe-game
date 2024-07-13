import { FastifyInstance } from 'fastify';
import { bootstrap } from 'fastify-decorators';

import cors from '@fastify/cors';
import ansicolor from 'ansicolor';

import TerminalHelper from '@/helper/terminal.helper';
import { errorHandler } from './error-handler';

import AuthPlugin from '@/plugins/auth.plugin';

class Server {
	constructor(public app: FastifyInstance, public port: number) {
		this.init();
	}

	private async init() {
		this.app
			.register(cors, {})
			.register(bootstrap, {
				directory: new URL('routes', import.meta.url),
				mask: /\.route\./
			})
			.register(AuthPlugin)
			.setErrorHandler(errorHandler)
			.setNotFoundHandler(() => {
				return {
					success: false,
					code: 'NOT_FOUND',
					message: 'Not Found'
				};
			});
	}

	public async listen() {
		return new Promise((resolve, reject) => {
			this.app.listen({ port: this.port }).then(resolve).catch(reject);

			TerminalHelper.success(
				'SERVER',
				`Successfully initialized on port: ${ansicolor.cyan(this.port)}`
			);
		});
	}
}

export default Server;
