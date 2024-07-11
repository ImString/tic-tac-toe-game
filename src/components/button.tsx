import clsx from 'clsx';
import { ActivityIndicator, Pressable } from 'react-native';

interface ButtonProps {
	isLoading?: boolean;
	className?: string;
	onClick?: () => void;
	children: React.ReactNode;
}

export const Button: React.FC<ButtonProps> = props => {
	return (
		<Pressable
			className={clsx(
				'flex-row items-center justify-center gap-2 border border-zinc-300 p-4',
				props.className
			)}
			onPress={props.onClick}
			disabled={props.isLoading}>
			{props.isLoading ? <ActivityIndicator className="text-lime-950" /> : props.children}
		</Pressable>
	);
};
