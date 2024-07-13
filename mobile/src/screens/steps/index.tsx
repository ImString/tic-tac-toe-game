import { useState } from 'react';
import { View, Image, Text } from 'react-native';
import { ProgressSteps } from '@/components/progressSteps';

enum StepForm {
	FIRST_STEP,
	TWO_STEP,
	THREE_STEP
}

const stepDetails = {
	[StepForm.FIRST_STEP]: {
		title: 'Bem-vindo',
		description:
			'Um dos jogos mais antigos do mundo agora\ndisponível no seu dispositivo móvel!',
		icon: require('@/assets/images/step-one.png')
	},
	[StepForm.TWO_STEP]: {
		title: 'Competir',
		description: 'Jogue com seus amigos e prove\nque você é um adversário digno!',
		icon: require('@/assets/images/step-two.png')
	},
	[StepForm.THREE_STEP]: {
		title: 'Placar',
		description: 'Ganhe pontos e faça seu próprio caminho\naté o topo do placar!',
		icon: require('@/assets/images/step-three.png')
	}
};

export const Steps: React.FC<{ onFinishStep?: () => void }> = props => {
	const [step, setStep] = useState<StepForm>(StepForm.FIRST_STEP);

	return (
		<View className="flex-1 items-center justify-center">
			<View>
				<Image source={stepDetails[step].icon} className="h-52 w-52" resizeMode="contain" />
			</View>
			<View className="mt-24 items-center gap-y-4">
				<Text className="font-medium text-2xl text-zinc-950 dark:text-zinc-400">
					{stepDetails[step].title}
				</Text>
				<Text className="text-center font-regular text-base text-zinc-950 dark:text-zinc-400">
					{stepDetails[step].description}
				</Text>
			</View>
			<ProgressSteps
				steps={[
					{ label: StepForm.FIRST_STEP, step: 1 },
					{ label: StepForm.TWO_STEP, step: 2 },
					{ label: StepForm.THREE_STEP, step: 3 }
				]}
				setLabel={setStep}
				onFinish={props.onFinishStep}
			/>
		</View>
	);
};
