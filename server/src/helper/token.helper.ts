import * as jwt from 'jsonwebtoken';

class TokenHelper {
	static generateToken(
		payload: object,
		subject: string,
		secret: string,
		expiresIn: number | string,
		issuer = 'gestbox.com.br',
		audience = 'JWT.Token',
		identifier?: string
	): string {
		return jwt.sign(payload, secret, {
			subject: subject,
			issuer: issuer,
			audience: audience,
			header: { alg: 'HS256', typ: `${identifier ?? `${identifier}+`}jwt` },
			expiresIn: expiresIn
		});
	}

	static verifyToken(
		token: string,
		secret: string,
		issuer = 'gestbox.com.br',
		audience = 'JWT.Token'
	): any {
		try {
			return jwt.verify(token, secret, {
				algorithms: ['HS256'],
				issuer: issuer,
				audience: audience
			});
		} catch (err: any) {
			return false;
		}
	}
}

export default TokenHelper;
