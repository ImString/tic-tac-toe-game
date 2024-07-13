import OIcon from '@/assets/svg/o-icon';
import XIcon from '@/assets/svg/x-icon';
import { colors } from '@/styles/colors';
import clsx from 'clsx';
import { Pressable, Text, View } from 'react-native';

interface ColProps {
	numRows: number;
	children: any;
}

const Box: React.FC<{ type: '' | 'X' | 'O' }> = props => {
	return (
		<Pressable
			style={{
				backgroundColor:
					props.type === 'X'
						? `${colors.light.red}33`
						: props.type === 'O'
							? `${colors.light.blue}33`
							: ''
			}}
			className={clsx('bg-opacity-20 p-3')}>
			{props.type === 'O' ? (
				<OIcon color={colors.light.blue} />
			) : props.type === 'X' ? (
				<View>
					<XIcon color={colors.light.red} />
				</View>
			) : (
				<Text></Text>
			)}
		</Pressable>
	);
};

export const OfflineGamePage = () => {
	return (
		<View className="flex-1 items-center justify-center gap-2">
			<View className="flex-row">
				<Box type="X" />
				<Box type="X" />
				<Box type="O" />
			</View>
			<View className="flex-row">
				<Box type="O" />
				<Box type="X" />
				<Box type="X" />
			</View>
			<View className="flex-row">
				<Box type="O" />
				<Box type="O" />
				<Box type="X" />
			</View>
		</View>
	);
};
