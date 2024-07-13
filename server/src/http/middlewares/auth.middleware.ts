import { FastifyRequest } from 'fastify';

import { RouterError } from '../routes/_errors/router.error';

class AuthenticateMiddleware {
	static handler(request: FastifyRequest, _opts: any, done: any) {
		const authToken = request.headers.authorization;
		if (!authToken) throw new RouterError('INVALID_TOKEN', 'Token is missing', 401);

		const [, token] = authToken.split(' ');

		done();
	}
}

export default AuthenticateMiddleware;
