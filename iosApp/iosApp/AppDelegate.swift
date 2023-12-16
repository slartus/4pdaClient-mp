//
//  AppDelegate.swift
//  iosApp
//
//  Created by Artem Slinkin on 16.12.2023.
//  Copyright © 2023 slartus. All rights reserved.
//

import Foundation
import shared
import SwiftUI

class AppDelegate: NSObject, UIApplicationDelegate {
    let root: RootComponent = RootComponentImpl(
        componentContext: DefaultComponentContext(lifecycle: ApplicationLifecycle())
    )
}
