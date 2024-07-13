export class RouterError extends Error {
	public code: string;
	public statusCode: number;

	constructor(code: string, message?: string, statusCode?: number) {
		super(message ?? 'Internal error.');
		this.code = code;
		this.statusCode = statusCode ?? 500;
	}
}
