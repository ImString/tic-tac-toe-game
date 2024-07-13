class RandomStringHelper {
	static generateRandomString(
		length: number,
		useLetters: boolean = true,
		useNumbers: boolean = true,
		useSymbols: boolean = true
	): string {
		let characters = '';

		if (useLetters) {
			characters += 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		}
		if (useNumbers) {
			characters += '0123456789';
		}
		if (useSymbols) {
			characters += '!@#$%^&*()_+[]{}|;:,.<>?';
		}

		if (!characters) {
			throw new Error('At least one type of characters must be selected');
		}

		let result = '';
		for (let i = 0; i < length; i++) {
			const randomIndex = Math.floor(Math.random() * characters.length);
			result += characters[randomIndex];
		}
		return result;
	}
}

export default RandomStringHelper;
