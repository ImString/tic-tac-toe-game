import { useState } from 'react';
import { Image, Text, View } from 'react-native';
import { Steps } from '@/screens/steps';
import { Button } from '@/components/button';
import Google from '@/assets/svg/google';
import Facebook from '@/assets/svg/facebook';

export const SignIn = () => {
	const [completedSteps, setCompletedSteps] = useState<boolean>(false);

	if (!completedSteps) {
		return <Steps onFinishStep={() => setCompletedSteps(true)} />;
	}

	const onClickOffline = () => {};

	const onClickGoogleAuth = () => {};

	const onClickFacebookAuth = () => {};

	return (
		<View className="flex-1 items-center justify-center">
			<View className="items-center">
				<Image
					source={require('@/assets/images/logo.png')}
					resizeMode="contain"
					className="h-20 w-24"
				/>
				<Text className="mt-4 font-semibold text-2xl">Bem-vindo</Text>
				<Text className="text-gray-600">Faça login para continuar.</Text>
			</View>
			<View className="absolute bottom-10 w-full flex-1 items-center gap-y-2">
				<Button className="w-10/12" onClick={onClickOffline}>
					<Text>Jogar offline</Text>
				</Button>
				<Button className="w-10/12" onClick={onClickGoogleAuth}>
					<Google />
					<Text className="text-lg">Faça login no Google</Text>
				</Button>
				<Button className="w-10/12" onClick={onClickFacebookAuth}>
					<Facebook />
					<Text className="text-lg">Faça login com o Facebook</Text>
				</Button>
			</View>
		</View>
	);
};
