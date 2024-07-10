import clsx from 'clsx';
import { useState } from 'react';
import { Text, View } from 'react-native';

type StepData = {
	label: string;
	step: number | 'completed';
};

interface ProgressStepsProps {
	steps: StepData[];
}

export const ProgressSteps: React.FC<ProgressStepsProps> = props => {
	const [activeStep, setActiveStep] = useState<number>(1);

	const nextStep = () => {
		setActiveStep(activeStep + 1);
	};

	const prevStep = () => {
		setActiveStep(activeStep - 1);
	};

	return (
		<View className="w-full max-w-xs flex-row justify-between">
			<Text className="text-zinc-400">Voltar</Text>
			<View className="flex-row gap-3">
				{props.steps.map(({ step, label }) => (
					<View className="relative z-10" key={step}>
						<View
							className={clsx('h-3 w-3 rounded-full', {
								'bg-light-blue dark:bg-dark-blue': step == activeStep,
								'bg-zinc-300': step != activeStep
							})}></View>
					</View>
				))}
			</View>
			<Text className="text-zinc-950">Próximo</Text>
		</View>
	);
};
