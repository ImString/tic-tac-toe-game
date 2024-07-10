import clsx from 'clsx';
import { useState } from 'react';
import { Text, View } from 'react-native';

type StepData = {
	label: any;
	step: number | 'completed';
};

interface ProgressStepsProps {
	steps: StepData[];
	setLabel: (label: any) => void;
	onFinish?: () => void;
}

export const ProgressSteps: React.FC<ProgressStepsProps> = props => {
	const [activeStep, setActiveStep] = useState<number>(1);

	const nextStep = () => {
		if (activeStep >= props.steps.length) {
			props.onFinish?.();
			return;
		}

		props.setLabel(props.steps[activeStep].label);
		setActiveStep(activeStep + 1);
	};

	const prevStep = () => {
		if (activeStep <= 1) return;

		props.setLabel(props.steps[activeStep - 2].label);
		setActiveStep(activeStep - 1);
	};

	return (
		<View className="absolute bottom-10 w-full flex-1 items-center">
			<View className="w-full max-w-xs flex-row justify-between">
				<Text
					className={clsx('text-zinc-400', { 'text-zinc-800': activeStep > 1 })}
					onPress={prevStep}
					disabled={activeStep == 1}>
					Voltar
				</Text>
				<View className="flex-row gap-3">
					{props.steps.map(({ step }) => (
						<View className="relative z-10" key={step}>
							<View
								className={clsx('h-3 w-3 rounded-full', {
									'bg-light-blue dark:bg-dark-blue': step == activeStep,
									'bg-zinc-300': step != activeStep
								})}></View>
						</View>
					))}
				</View>
				<Text className="text-zinc-950" onPress={nextStep}>
					Próximo
				</Text>
			</View>
		</View>
	);
};
