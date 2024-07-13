import React from 'react';

import { NavigationContainer } from '@react-navigation/native';
import { SignIn } from '@/screens/signIn';
import { OfflineGamePage } from '@/screens/game/offlineGame';

export function Routes() {
	return (
		<NavigationContainer independent={true}>
			<SignIn />
			{/* <OfflineGamePage /> */}
		</NavigationContainer>
	);
}
