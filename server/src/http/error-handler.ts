import type { FastifyInstance } from 'fastify';
import { ZodError } from 'zod';

import { RouterError } from '@/http/routes/_errors/router.error';
import { BadRequestError } from '@/http/routes/_errors/bad-request.error';
import { UnauthorizedError } from '@/http/routes/_errors/unauthorized.error';

type FastifyErrorHandler = FastifyInstance['errorHandler'];

export const errorHandler: FastifyErrorHandler = (error, request, reply) => {
	if (error instanceof ZodError) {
		return reply.status(400).send({
			success: false,
			code: 'VALIDATION_ERROR',
			message: 'Validation error',
			errors: error.flatten().fieldErrors
		});
	}

	if (error instanceof Error && error.validation) {
		return reply.status(400).send({
			success: false,
			code: 'VALIDATION_ERROR',
			message: 'Validation error',
			errors: error.validation.map(err => ({
				key: err.params?.missingProperty,
				value: err.message
			}))
		});
	}

	if (error instanceof BadRequestError) {
		return reply.status(400).send({
			success: false,
			code: 'BAD_REQUEST',
			message: error.message
		});
	}

	if (error instanceof UnauthorizedError) {
		return reply.status(401).send({
			success: false,
			code: 'UNAUTHORIZED',
			message: error.message
		});
	}

	if (error instanceof RouterError) {
		return reply.status(error.statusCode).send({
			success: false,
			code: error.code,
			message: error.message
		});
	}

	if (error.statusCode === 401) {
		reply.code(401).send({ was: 'unauthorized' });
		return;
	}

	console.error(error);

	return reply.status(500).send({
		success: false,
		code: 'INTERNAL_ERROR',
		message: 'Internal server error'
	});
};
