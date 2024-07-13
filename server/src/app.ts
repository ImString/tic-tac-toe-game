import fastify, { FastifyInstance } from 'fastify';
import Server from '@/http/server';

import terminal from '@/helper/terminal.helper';
import rnd from '@/helper/randomString.helper';

class App {
	public appPort = process.env.SERVER_PORT || 3000;

	public jwtSecret = process.env.JWT_SECRET || rnd.generateRandomString(16, true, true, true);
	public jwtIssuer = process.env.JWT_ISSUER;
	public jwtAudience = process.env.JWT_AUDIENCE;

	public app: FastifyInstance;
	public server: Server;

	constructor(appInit: {}) {
		this.app = fastify({
			logger: false
		});
		this.server = new Server(this.app, Number(this.appPort));
	}

	public async init() {
		await this.server.listen();

		terminal.success('CORE', 'Successfully initialized!');
	}
}

export default App;
