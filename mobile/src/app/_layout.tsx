import '@/styles/global.css';

import { View, StatusBar, Switch } from 'react-native';
import { useColorScheme } from 'nativewind';
import { Slot } from 'expo-router';

import {
	useFonts,
	Inter_500Medium,
	Inter_400Regular,
	Inter_600SemiBold
} from '@expo-google-fonts/inter';

import { Loading } from '@/components/loading';

const Layout: React.FC<{}> = () => {
	const { colorScheme, setColorScheme } = useColorScheme();
	const [fontsLoaded] = useFonts({
		Inter_500Medium,
		Inter_400Regular,
		Inter_600SemiBold
	});

	setColorScheme('system');
	if (!fontsLoaded) {
		return <Loading />;
	}

	return (
		<View className="flex-1 bg-zinc-100 dark:bg-black">
			<StatusBar
				barStyle={colorScheme === 'dark' ? 'light-content' : 'dark-content'}
				backgroundColor="transparent"
				translucent
			/>
			<Slot />
		</View>
	);
};

export default Layout;
