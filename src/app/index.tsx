import { View } from 'react-native';
import { Routes } from '@/app/routes';

const Index: React.FC<{}> = () => {
	return (
		<View className="flex-1 px-5">
			<Routes />
		</View>
	);
};

export default Index;
